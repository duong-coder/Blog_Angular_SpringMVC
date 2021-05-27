import { Component, OnInit, forwardRef, OnChanges } from '@angular/core';
import { FormBuilder, NG_VALUE_ACCESSOR, NG_VALIDATORS, FormArray } from '@angular/forms';
import { faAward, faBookmark, faBullseye, faCalendarAlt, faEnvelope, faLightbulb, faMapMarkedAlt, faPen, faPhone, faUser, faUsers } from '@fortawesome/free-solid-svg-icons';
import { Account } from 'src/app/model/account';
import { AccountService } from 'src/app/service/account.service';
import { IProfileContent } from '../profile-detail/profile-detail.component';

@Component({
  selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.css', '../profile-detail/profile-detail.component.css']
})
export class ProfileEditComponent implements OnInit, OnChanges {
  account: Account = new Account();
  skills: { item, percent }[];

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
  isEdit: true;
  profileForm = this.fb.group({
    objective: [''],
    awards: [''],
    addInformation: [''],
    references: [''],
    educationDTOs: this.fb.array([]),
    workExperienceDTOs: this.fb.array([]),
  });

  constructor(
    private acccountService: AccountService,
    private fb: FormBuilder) { }

  ngOnInit(): void {
    this.getProfile();
  }
  ngOnChanges(): void {
    // this.mapDataToForm();
  }

  getProfile(): void {
    this.acccountService.getAccountByPhone().subscribe({
      next: (res) => {
        if (res.status === 200) {
          this.account = { ...res.body };
          this.account.educationDTOs = res.body.educationDTOs.map(edu => {
            const eduRt = edu;
            eduRt.dateEnd = new Date(edu.dateEnd);
            eduRt.dateStart = new Date(edu.dateStart);
            return eduRt;
          });
          this.account.workExperienceDTOs = res.body.workExperienceDTOs.map(we => {
            const weRt = we;
            weRt.dateEnd = new Date(we.dateEnd);
            weRt.dateStart = new Date(we.dateStart);
            return weRt;
          });
          this.skills = this.account.skillDTOs.map(dto => {
            return { item: dto, percent: (dto.level / 5) * 100 };
          });
          console.log('response', this.account);
          this.mapDataToForm();
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

  mapDataToForm(): void {
    const listEduForm = this.fb.array([]);
    const listWEForm = this.fb.array([]);

    this.account.educationDTOs.forEach(edu => {
      const eduForm = this.fb.group({
        id: [edu.id],
        name: [edu.name],
        description: [edu.description],
        dateStart: [edu.dateStart.toISOString().split('T')[0]],
        dateEnd: [edu.dateEnd.toISOString().split('T')[0]],
        gpa: [edu.gpa]
      });

      listEduForm.push(eduForm);
    });

    this.account.workExperienceDTOs.forEach(we => {
      const weForm = this.fb.group({
        id: [we.id],
        companyOrAppName: [we.companyOrAppName],
        titleOrPosition: [we.titleOrPosition],
        description: [we.description],
        dateStart: [we.dateStart.toISOString().split('T')[0]],
        dateEnd: [we.dateEnd.toISOString().split('T')[0]]
      });

      listWEForm.push(weForm);
    });
    this.profileForm = this.fb.group({
      objective: [this.account.objective],
      awards: [this.account.awards],
      addInformation: [this.account.addInformation],
      references: [this.account.references],
      educationDTOs: listEduForm,
      workExperienceDTOs: listWEForm,
    });
  }

  getPercentSkill(): void {
  }

  update(): void {
    console.log('post in serve', this.profileForm.getRawValue());
  }

}
