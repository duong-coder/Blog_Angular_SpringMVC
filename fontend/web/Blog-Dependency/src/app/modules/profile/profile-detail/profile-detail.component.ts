import { Component, OnInit } from '@angular/core';
import { faAward, faBookmark, faBullseye, faCalendarAlt, faEnvelope, faLightbulb, faMapMarkedAlt, faPen, faPhone, faUser, faUsers } from '@fortawesome/free-solid-svg-icons';

interface IProfileContent {
  hasIcon: boolean;
  icon?: any;
  title: string;
}

@Component({
  selector: 'app-profile-detail',
  templateUrl: './profile-detail.component.html',
  styleUrls: ['./profile-detail.component.css']
})
export class ProfileDetailComponent implements OnInit {
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
  constructor() { }

  ngOnInit(): void {
  }

}
