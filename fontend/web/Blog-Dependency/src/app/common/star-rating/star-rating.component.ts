import { Component, ElementRef, EventEmitter, Input, OnChanges, OnInit, Output, ViewEncapsulation } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { FaIconComponent } from '@fortawesome/angular-fontawesome';
import { faStar } from '@fortawesome/free-solid-svg-icons';
import { Skill } from 'src/app/model/skill';
import { ModalService } from 'src/app/service/modal.service';

@Component({
  selector: 'app-star-rating',
  templateUrl: './star-rating.component.html',
  styleUrls: ['./star-rating.component.css'],
  providers: [ModalService]
})
export class StarRatingComponent implements OnInit, OnChanges {
  @Input() id: FormControl;
  @Input() skillFormGroup: FormGroup;
  @Output() skillRating = new EventEmitter<FormGroup>();

  faStar = faStar;
  element: HTMLElement;
  levels = [1, 2, 3, 4, 5];

  constructor(private elementRef: ElementRef, private modalService: ModalService) {
    this.element = elementRef.nativeElement;
  }

  ngOnInit(): void {
    // this.element.
    document.body.appendChild(this.element);
    this.element.addEventListener('click', el => {
      this.closeModal();
    });
    this.modalService.set(this, true);
  }
  ngOnChanges(): void{
    console.log('CHANGE MODAL');
    this.getSkillRating(this.skillFormGroup.get('level').value);

    // this.modalService.set(this, false);
  }

  openModal(): void {
    console.log('OPEN');
    this.element.style.display = 'block';
    document.body.style.overflow = 'hidden';
  }


  closeModal(): void {
    console.log('CLOSE');
    this.element.style.display = 'none';
    document.body.style.overflow = 'visible';
  }

  getSkillRating(level: number): void {
    this.skillFormGroup.get('level').setValue(level);
    this.skillRating.emit(this.skillFormGroup);

    const iconElements = this.element.getElementsByClassName('--icon');
    for (let i = 0; i < iconElements.length; i++) {
      iconElements.item(i).classList.remove('checked');
      for (let t = 0; t < level; t++) {
        iconElements.item(t).classList.add('checked');
      }
    }
  }
}
