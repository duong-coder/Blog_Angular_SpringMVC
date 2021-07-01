import { Component, OnInit, forwardRef, OnChanges, ElementRef, ViewChild } from '@angular/core';
import { FormBuilder, NG_VALUE_ACCESSOR, NG_VALIDATORS, FormArray } from '@angular/forms';
import { faFacebook, faGithub, faTwitter } from '@fortawesome/free-brands-svg-icons';
import { faAward, faBookmark, faBullseye, faCalendarAlt, faEnvelope, faLightbulb, faMapMarkedAlt, faPen, faPhone, faUser, faUsers } from '@fortawesome/free-solid-svg-icons';
import { StarRatingComponent } from 'src/app/common/star-rating/star-rating.component';
import { Account } from 'src/app/model/account';
import { Skill } from 'src/app/model/skill';
import { AccountService } from 'src/app/service/account.service';
import { FormService } from 'src/app/service/form.service';
import { ModalService } from 'src/app/service/modal.service';
import { IProfileContent } from '../profile-detail/profile-detail.component';

@Component({
  selector: 'app-profile-edit',
  templateUrl: './profile-edit.component.html',
  styleUrls: ['./profile-edit.component.css', '../profile-detail/profile-detail.component.css']
})
export class ProfileEditComponent implements OnInit, OnChanges {
  @ViewChild(StarRatingComponent)
  starRatingComponent: StarRatingComponent;

  skillRating: Skill = new Skill();

  account: Account = new Account();

  faCalendar = faCalendarAlt;
  faUser = faUser;
  faPhone = faPhone;
  faMail = faEnvelope;
  faGithub = faGithub;
  faTwitter = faTwitter;
  faFacebook = faFacebook;
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
  profileForm = this.formService.createAccountFormGroup();
  skills: Skill[];

  constructor(
    private acccountService: AccountService,
    private fb: FormBuilder,
    private modalService: ModalService,
    private formService: FormService) { }

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
      const eduForm = this.formService.createEducationFormGroup(edu);

      listEduForm.push(eduForm);
    });

    this.account.workExperienceDTOs.forEach(we => {
      const weForm = this.formService.createWorkExperienceFormGroup(we);

      listWEForm.push(weForm);
    });

    this.skills = this.account.skillDTOs;
    this.profileForm = this.formService.createAccountFormGroupWithData(this.account, listEduForm, listWEForm);
  }

  getPercentSkill(): void {
  }
  openSkillRatingModal(skill: Skill): void {
    this.skillRating = skill;
    // const ele = document.getElementsByTagName('app-star-rating').item(0);
    // const eleRef = new ElementRef<Element>(ele);
    // const modal = new StarRatingComponent(eleRef, this.modalService);
    const modal = this.starRatingComponent;

    this.modalService.set(modal, false);
    console.log('OPEN MODAL', skill);

  }
  getSkillRating(item: Skill): void {
    const skillDTOs = this.account.skillDTOs;
    let skill: Skill;
    if (skillDTOs != null && skillDTOs !== undefined) {
      skill = skillDTOs.find(s => {
        return s.skill === item.skill;
      });
      skill.level = item.level;
    }
  }

  update(): void {
    const accountAfterUpdate = this.profileForm.getRawValue();
    accountAfterUpdate.skillDTOs = this.account.skillDTOs;
    accountAfterUpdate.gender = accountAfterUpdate.gender === 'Female';
    accountAfterUpdate.password = this.account.password;
    accountAfterUpdate.role = this.account.role;
    accountAfterUpdate.username = this.account.username;
    accountAfterUpdate.dateCreate = this.account.dateCreate;

    console.log('post in serve', accountAfterUpdate);

    this.acccountService.updateByUsername(accountAfterUpdate).subscribe({
      next: (res) => {
        console.log('RESPONSE UPDATE: ', res);

      },
      error: (error) => {
        console.error('RESPONSE UPDATE: ', error);

      },
      complete: () => {
        console.log('RESPONSE UPDATE: COMPLETE');

      }
    });
  }
  resizeInput(element: HTMLTextAreaElement): void {
    element.style.height = 'auto';
    element.style.height = element.scrollHeight + 'px';
  }
}
