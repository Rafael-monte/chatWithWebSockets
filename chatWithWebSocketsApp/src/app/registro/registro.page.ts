import { Component, OnInit, ViewChild } from '@angular/core';
import { Form, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { AnimationBuilder, AnimationController, IonHeader, ToastController } from '@ionic/angular';
import { User } from '../core/models/user.models';
import { UserService } from '../core/services/user.service';


@Component({
  selector: 'app-registro',
  templateUrl: './registro.page.html',
  styleUrls: ['./registro.page.scss'],
})
export class RegistroPage implements OnInit {

  constructor(
    private userService: UserService,
    private toast: ToastController,
    private router: Router,
    private animationCtrl: AnimationController
  ) { }

  usuario: User = new User();
  confirmacaoPassword: string = '';
  ngOnInit() {
  }

  async showWarn(msg: string) {
    const aviso = await this.toast.create({
      header: 'Cuidado!',
      message: `${msg}`,
      buttons: [{
        text: 'Ok'
      }],
      duration: 2000
    });
    return aviso.present();
  }

  putIdentificator(name: String) {
    if (name.charAt(0) !== '@') {
      name = `@${name}`;
    }
    name.replace(/\s/g, "");
    return this.usuario.username = name;
  }
  removeWhiteSpaces(name: String) {
    if (name.indexOf(" ") !== -1) {
      this.showWarn("Apelidos com espaço serão substituidos por underline");
    }
    name = name.replace(/\s/g, "_");
    
    this.usuario.username = name;
  }

  async submit(form: FormGroup) {
    if(!form.valid) {
      this.markFormGroupTouched(form);
    }
    if (this.usuario.username.charAt(0) !== '@') {
      this.usuario.username = `@${this.usuario.username}`;
    }
    const promise = await this.saveInApi();
    if (promise === null) {
     return this.clearForm()
    } else {
     return this.router.navigate([`home`]);
    }
  }
  clearForm() {
   this.usuario.username = '';
   this.usuario.password = '';
   this.usuario.email = '';
   this.confirmacaoPassword = '';
   return this.usuario;
  }
  saveInApi() {
    return new Promise<User>((resolve, reject) => {
      this.userService.save(this.usuario).subscribe((res: User) => {
        return resolve(res);
      }, (error: any) => {
        this.showWarn("Parece que alguém já utiliza esse usuario! Tente novamente!");
        reject(error);
        return resolve(null);
      });
    });
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
