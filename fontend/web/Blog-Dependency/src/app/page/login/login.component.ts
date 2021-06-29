import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import { Router } from '@angular/router';
import { AccountLogin } from 'src/app/model/acccount-login';
import { JwtToken } from 'src/app/model/token';
import { JwttokenService } from 'src/app/service/jwttoken.service';
import {AccountService} from '../../service/account.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm = new FormGroup({
    phone: new FormControl('duongnh'),
    password: new FormControl(''),
    rememberMe: new FormControl('true')
  });

  private jwtToken: JwtToken;

  constructor(
    private router: Router,
    private accountService: AccountService,
    private jwttokenService: JwttokenService) { }

  ngOnInit(): void {
  }

  submit(): void{
    const accountLogin: AccountLogin = new AccountLogin();
    accountLogin.phone = this.loginForm.get('phone').value;
    accountLogin.password = this.loginForm.get('password').value;
    accountLogin.rememberMe = this.loginForm.get('rememberMe').value;

    this.accountService.login(accountLogin).subscribe(
      token => {
        this.router.navigateByUrl('/duongnh/home');
      },
      function error(err): void{
        console.log(err);
      }
    );
  }

}
