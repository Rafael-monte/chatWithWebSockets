import { Component, OnInit } from '@angular/core';
import { CookieService } from '../core/services/cookie.service';
import { User } from '../core/models/user.models';
import { MenuController } from '@ionic/angular';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.page.html',
  styleUrls: ['./inicio.page.scss'],
})
export class InicioPage implements OnInit {

  constructor(
    private cookieService: CookieService,
    private menu: MenuController
  ) { }

  usuario: User = new User();
  ngOnInit() {
    this.getUserFromCookie()
  }
  getUserFromCookie() {
    this.usuario = JSON.parse(this.cookieService.getCookie('currentUser'));
  }

  openMenu() {
    this.menu.enable(true, 'first');
    this.menu.open('first');
  }
}
