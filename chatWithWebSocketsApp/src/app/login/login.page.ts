import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AlertController, ToastController } from '@ionic/angular';
import { User } from '../core/models/user.models';
import { UserService } from '../core/services/user.service';
import { AuthenticationService } from '../core/services/authentication.service';
import { CookieService } from '../core/services/cookie.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

  constructor(
    private userService: UserService,
    private toast: ToastController,
    private alertCtrl: AlertController,
    private router: Router,
    private cookieService: CookieService
    
    ) { }

  tries: number = 0;
  usuario: User = new User();
  readonly MAX_TRIES_NUMBER: number = 3;

  ngOnInit() {
  }

  async showAviso() {
    if (this.tries === this.MAX_TRIES_NUMBER) {
      this.showAlert();
    }
    const aviso = await this.toast.create({
     header: 'Oops!',
     message: `Tente novamente! (${this.tries}/3)`,
     duration: 2000,
     buttons: [{
       text: 'Ok',
       handler: () => {
         aviso.dismiss();
       }
     }] 
    });
    await aviso.present();
  }

  async showAlert() {
    const alerta = await this.alertCtrl.create({
      header: 'Está tudo bem aí?',
      subHeader: 'O numero máximo de tentativas permitidas foi excedido, portanto te pedimos para que desista por hoje ou mande uma verificação por email, \
       caso contrário sua conta será desativada!',
      buttons: [
        {
          text: 'Ok, vou desistir por enquanto!',
          handler: () => {
            this.usuario.email = '';
            this.usuario.password = '';
            this.router.navigate([`home`]);
          },
        },
        {
          text: 'Só vou desistir lutando! Passa essa solicitação aí!',
          handler: () => {
            this.usuario.email = '';
            this.usuario.password = '';
            this.router.navigate([`home`]);
          }
        }
      ]
    });
    await alerta.present();
  }

  async login(form: FormGroup) {
    if (!form.valid) {
      this.markFormGroupTouched(form);
    }
    const promise = await this.loginInApi();
  }
  loginInApi() {
    return new Promise<User>((resolve, reject) => {
      this.userService.login(this.usuario).subscribe((res: User) => {
          this.cookieService.setCookie('currentUser', JSON.stringify(res), 20);
          this.router.navigate([`inicio`]);
      }, (error: any) => {
        this.tries++;
        this.showAviso();
        reject(error);
        return resolve(null);
      });
    })
  }

  private markFormGroupTouched(formGroup: FormGroup) {
    (<any>Object).values(formGroup.controls).forEach(control => {
      control.markAsTouched();

      if (control.controls) {
        this.markFormGroupTouched(control);
      }
    });
  }

}
