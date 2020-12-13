import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  constructor(private router: Router) {}

  redirectToRegistro(): void {
    this.router.navigate([`registro`]);
  }
  redirectToLogin(): void {
    this.router.navigate([`login`]);
  }
}