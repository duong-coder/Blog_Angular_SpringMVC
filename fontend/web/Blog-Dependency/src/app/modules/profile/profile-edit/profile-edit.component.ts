import { Component, OnInit, forwardRef, OnChanges, ElementRef } from '@angular/core';
import { FormBuilder, NG_VALUE_ACCESSOR, NG_VALIDATORS, FormArray } from '@angular/forms';
import { faAward, faBookmark, faBullseye, faCalendarAlt, faEnvelope, faLightbulb, faMapMarkedAlt, faPen, faPhone, faUser, faUsers } from '@fortawesome/free-solid-svg-icons';
import { StarRatingComponent } from 'src/app/common/star-rating/star-rating.component';
import { Account } from 'src/app/model/account';
import { Skill } from 'src/app/model/skill';
import { AccountService } from 'src/app/service/account.service';
import { ModalService } from 'src/app/service/modal.service';
import { IProfileContent } from '../profile-detail/profile-detail.component';

@Component({
  selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.css', '../profile-detail/profile-detail.component.css']
})
export class ProfileEditComponent implements OnInit, OnChanges {
  account: Account = new Account();
  skillRating: Skill = new Skill(0, '', 0);

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
    phonenumber: [''],
    birthday: [new Date()],
    address: [''],
    email: [''],
    gender: [''],
    hobby: [''],
    educationDTOs: this.fb.array([]),
    workExperienceDTOs: this.fb.array([]),
  });

  constructor(
    private acccountService: AccountService,
    private fb: FormBuilder,
    private modalService: ModalService) { }

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
          this.skillRating = this.account.skillDTOs[0];

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
      phonenumber: [this.account.phonenumber],
      birthday: [new Date(this.account.birthday).toISOString().split('T')[0]],
      address: [this.account.address],
      email: [this.account.email],
      gender: [this.account.gender ? 'Male' : 'Female'],
      hobby: [this.account.hobby],
      educationDTOs: listEduForm,
      workExperienceDTOs: listWEForm,
    });
  }

  getPercentSkill(): void {
  }
  openSkillRatingModal(skill: Skill): void {
    this.skillRating = skill;
    const ele = document.getElementsByTagName('app-star-rating').item(0);
    const eleRef = new ElementRef<Element>(ele);
    const modal = new StarRatingComponent(eleRef, this.modalService);

    this.modalService.set(modal);
    console.log('OPEN MODAL', skill);

  }
  getSkillRating(item: Skill): void {
    console.log('SKILL RATING', item);
    const skill = this.account.skillDTOs.find(s => {
      return s.skill === item.skill;
    });
    skill.level = item.level;
  }

  update(): void {
    const accountAfterUpdate = this.profileForm.getRawValue() as Account;
    accountAfterUpdate.skillDTOs = this.account.skillDTOs;

    console.log('post in serve', accountAfterUpdate);

    this.acccountService.updateByUsername(accountAfterUpdate).subscribe({
      next: (res) => {
        console.log('RESPONSE UPDATE: ', res);

      },
      error: (error) => {
        console.error('RESPONSE UPDATE: ', error);

      },
      complete: () => {
        console.error('RESPONSE UPDATE: COMPLETE');

      }
    });
  }
  resizeInput(element: HTMLTextAreaElement): void {
    element.style.height = 'auto';
    element.style.height = element.scrollHeight + 'px';
  }
}
