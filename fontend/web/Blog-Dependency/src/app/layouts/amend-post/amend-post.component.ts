import { Component, OnInit } from '@angular/core';
import { Account } from 'src/app/model/account';
import { AccountService } from 'src/app/service/account.service';

@Component({
  selector: 'app-amend-post',
  templateUrl: './amend-post.component.html',
  styleUrls: ['./amend-post.component.css']
})
export class AmendPostComponent implements OnInit {
  account: Account = new Account();

  constructor(
    private accountService: AccountService
  ) { }

  ngOnInit(): void {
    this.getLinkSocialNetworkById();
  }
  getLinkSocialNetworkById(): void {
    this.accountService.getLinkSocialNetworkById().subscribe(
      (res) => {
        this.account = res.body;
      }
    );
  }
}
