import { Education } from './education';
import { WorkExperience } from './work-experience';

export interface KindTimeItem {
    obj: Education | WorkExperience;
    kind: string;
}
