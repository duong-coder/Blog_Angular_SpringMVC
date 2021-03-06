import { Component, OnInit, DoCheck } from '@angular/core';
import { Account } from 'src/app/model/account';
import { AccountService } from 'src/app/service/account.service';
import { PostService } from 'src/app/service/post.service';

@Component({
  selector: 'app-default',
  templateUrl: './default.component.html',
  styleUrls: ['./default.component.css']
})
export class DefaultComponent implements OnInit {
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
