import { FormGroup } from '@angular/forms';
import { Education } from './education';
import { WorkExperience } from './work-experience';

export interface KindTimeItemForm {
    formGroup: FormGroup;
    kind: string;
    index: number;
}

export interface ItemSkillFormGroup {
  skillFormGroup: FormGroup;
  index: number;
}
