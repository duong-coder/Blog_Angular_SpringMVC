import { Injectable } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { Account } from '../model/account';
import { Education } from '../model/education';
import { WorkExperience } from '../model/work-experience';

@Injectable({
  providedIn: 'root'
})
export class FormService {

  constructor(private fb: FormBuilder) { }

  // createBehaviorForm(): any{
  // }

  createAccountFormGroup(): FormGroup {
    const accountForm = this.fb.group({
      fullname: [''],
      objective: [''],
      awards: [''],
      addInformation: [''],
      references: [''],
      phonenumber: [''],
      birthday: [new Date()],
      address: [''],
      email: [''],
      facebook: [''],
      github: [''],
      twitter: [''],
      gender: [''],
      hobby: [''],
      educationDTOs: this.fb.array([]),
      workExperienceDTOs: this.fb.array([]),
    });

    return accountForm;
  }

  createAccountFormGroupWithData(account: Account, listEduForm: FormArray, listWEForm: FormArray): FormGroup {
    const accountForm = this.fb.group({
      fullname: [account.fullname],
      objective: [account.objective],
      awards: [account.awards],
      addInformation: [account.addInformation],
      references: [account.references],
      phonenumber: [account.phonenumber],
      birthday: [new Date(account.birthday).toISOString().split('T')[0]],
      address: [account.address],
      email: [account.email],
      facebook: [account.facebook],
      github: [account.github],
      twitter: [account.twitter],
      gender: [account.gender ? 'Male' : 'Female'],
      hobby: [account.hobby],
      educationDTOs: listEduForm,
      workExperienceDTOs: listWEForm,
    });

    return accountForm;
  }

  createEducationFormGroup(edu: Education): FormGroup {
    let eduForm = this.fb.group({
      id: [],
      name: [''],
      description: [''],
      dateStart: [''],
      dateEnd: [''],
      gpa: [''],
      sortIndex: [],
      accountDTO: [new Account()]
    });

    if (edu) {
      eduForm = this.fb.group({
        id: [edu.id],
        name: [edu.name],
        description: [edu.description],
        dateStart: [edu.dateStart.toISOString().split('T')[0]],
        dateEnd: [edu.dateEnd.toISOString().split('T')[0]],
        gpa: [edu.gpa],
        sortIndex: [edu.sortIndex],
        accountDTO: [edu.accountDTO]
      });
    }

    return eduForm;
  }

  createWorkExperienceFormGroup(we: WorkExperience): FormGroup {
    let weForm = this.fb.group({
      id: [],
      companyOrAppName: [''],
      titleOrPosition: [''],
      description: [''],
      dateStart: [''],
      dateEnd: [''],
      sortIndex: [],
      accountDTO: [new Account()]
    });

    if (we) {
      weForm = this.fb.group({
        id: [we.id],
        companyOrAppName: [we.companyOrAppName],
        titleOrPosition: [we.titleOrPosition],
        description: [we.description],
        dateStart: [we.dateStart.toISOString().split('T')[0]],
        dateEnd: [we.dateEnd.toISOString().split('T')[0]],
        sortIndex: [we.sortIndex],
        accountDTO: [we.accountDTO]
      });
    }

    return weForm;
  }
}
