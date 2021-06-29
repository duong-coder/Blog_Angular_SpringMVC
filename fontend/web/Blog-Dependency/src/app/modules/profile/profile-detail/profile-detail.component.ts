import { Component, OnChanges, OnInit } from '@angular/core';
import { faAward, faBookmark, faBullseye, faCalendarAlt, faEnvelope, faLightbulb, faMapMarkedAlt, faPen, faPhone, faUser, faUsers } from '@fortawesome/free-solid-svg-icons';
import { Account } from 'src/app/model/account';
import { AccountService } from 'src/app/service/account.service';

export interface IProfileContent {
  hasIcon: boolean;
  icon?: any;
  title: string;
}

@Component({
  selector: 'app-profile-detail',
  templateUrl: './profile-detail.component.html',
  styleUrls: ['./profile-detail.component.css']
})
export class ProfileDetailComponent implements OnInit, OnChanges {
  account: Account = new Account();
  // skills: { item, percent }[];

  faCalendar = faCalendarAlt;
  faUser = faUser;
  faPhone = faPhone;
  faMail = faEnvelope;
  faAddress = faMapMarkedAlt;

  profileContents: IProfileContent[] = [
    { hasIcon: true, icon: faBullseye, title: 'Objective' },
    { hasIcon: true, icon: faLightbulb, title: 'Education' },
    { hasIcon: true, icon: faUsers, title: 'Work Experience' },
    { hasIcon: true, icon: faAward, title: 'Honors & Awards' },
    { hasIcon: true, icon: faPen, title: 'Additional Information' },
    { hasIcon: true, icon: faBookmark, title: 'References' },
    { hasIcon: false, icon: undefined, title: 'Skills' },
    { hasIcon: false, icon: undefined, title: 'INTERESTS' }
  ];


  constructor(private acccountService: AccountService) { }

  ngOnChanges(): void {

  }

  ngOnInit(): void {
    this.acccountService.getAccountByPhone().subscribe({
      next: (res) => {
        if (res.status === 200) {
          this.account = res.body;
        }
      },
      error: (error) => {
        console.error(error);
      },
      complete: () => {
        console.log('Complete get profile');
      }
    });
  }
}
