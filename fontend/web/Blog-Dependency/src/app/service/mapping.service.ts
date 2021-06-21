import { Injectable } from '@angular/core';
import { Account } from '../model/account';
import { Education } from '../model/education';
import { Post } from '../model/post';
import { Skill } from '../model/skill';
import { WorkExperience } from '../model/work-experience';

@Injectable({
  providedIn: 'root'
})
export class MappingService {

  constructor() { }

  mappingAccount(accountMapping: Account): Account {
    const account = new Account();

    account.phonenumber = accountMapping.phonenumber;
    account.password = accountMapping.password;
    account.dateCreate = new Date(accountMapping.dateCreate);
    account.fullname = accountMapping.fullname;
    account.birthday = new Date(accountMapping.birthday);
    account.address = accountMapping.address;
    account.email = accountMapping.email;
    account.gender = accountMapping.gender;
    account.github = accountMapping.github;
    account.facebook = accountMapping.facebook;
    account.twitter = accountMapping.twitter;
    account.role = accountMapping.role;
    account.hobby = accountMapping.hobby;
    account.objective = accountMapping.objective;
    account.addInformation = accountMapping.addInformation;
    account.references = accountMapping.references;
    account.awards = accountMapping.awards;

    account.postDTOs = this.mappingPostArray(accountMapping.postDTOs);

    account.skillDTOs = this.mappingSkillArray(accountMapping.skillDTOs);
    account.educationDTOs = this.mappingEducationArray(accountMapping.educationDTOs);
    account.workExperienceDTOs = this.mappingWorkExperienceArray(accountMapping.workExperienceDTOs);

    return account;
  }

  mappingPost(postMapping: any): Post {
    const post = new Post();

    post.id = postMapping.id;
    post.heading = postMapping.heading;
    post.subHeading = postMapping.subHeading;
    post.content = postMapping.content;
    post.urlImage = postMapping.urlImage;
    post.dateCreate = new Date(post.dateCreate);

    return post;
  }

  mappingPostArray(postArrayMapping: any): Array<Post> {
    let posts = new Array<Post>();

    posts = postArrayMapping.map(post => {
      return this.mappingPost(post);
    });

    return posts;
  }

  mappingSkill(skillMapping: any): Skill {
    const skill = new Skill(0, '', 0);

    skill.id = skillMapping.id;
    skill.skill = skillMapping.skill;
    skill.level = skillMapping.level;

    return skill;
  }
  mappingSkillArray(skillArrayMapping: any): Array<Skill> {
    let skills = new Array<Skill>();

    skills = skillArrayMapping.map(skill => {
      return this.mappingSkill(skill);
    });

    return skills;
  }

  mappingEducation(educationMapping: any): Education{
    const education = new Education();

    education.id = educationMapping.id;
    education.name = educationMapping.name;
    education.gpa = educationMapping.gpa;
    education.description = educationMapping.description;
    education.dateStart = new Date(educationMapping.dateStart);
    education.dateEnd = new Date(educationMapping.dateEnd);

    return education;
  }

  mappingEducationArray(educationArrayMapping: any): Array<Education> {
    let educations = new Array<Education>();

    educations = educationArrayMapping.map(education => {
      return this.mappingEducation(education);
    });

    return educations;
  }

  mappingWorkExperience(weMapping: any): WorkExperience{
    const workExperience = new WorkExperience();

    workExperience.id = weMapping.id;
    workExperience.companyOrAppName = weMapping.companyOrAppName;
    workExperience.titleOrPosition = weMapping.titleOrPosition;
    workExperience.description = weMapping.description;
    workExperience.dateStart = new Date(weMapping.dateStart);
    workExperience.dateEnd = new Date(weMapping.dateEnd);

    return workExperience;
  }

  mappingWorkExperienceArray(workExperienceArrayMapping: any): Array<WorkExperience> {
    let workExperiences = new Array<WorkExperience>();

    workExperiences = workExperienceArrayMapping.map(we => {
      return this.mappingWorkExperience(we);
    });

    return workExperiences;
  }
}
