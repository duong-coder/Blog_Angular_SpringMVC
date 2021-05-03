import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
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
    phone: new FormControl('0773314448'),
    password: new FormControl(''),
    rememberMe: new FormControl('true')
  });

  private jwtToken: JwtToken;

  constructor(
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
      function next(token: JwtToken): void{
        localStorage.setItem('id_token', token.id_token);
      },
      function error(err): void{
        console.log(err);
      },
      function complete(): void{
        console.log('Complete Call API Login');
        location.replace("/home");
      }
    );
  }

}
