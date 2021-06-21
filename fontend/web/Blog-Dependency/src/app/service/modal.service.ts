import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ModalService {
  modal: any;

  constructor() { }
  set(modal: any): void {
    this.modal = modal;
    console.log('MODALS: ', this.modal);
    this.open(modal.id);
  }
  open(id: string): void {
    if (this.modal && this.modal.id === id) {
      this.modal.openModal();
    }
  }
  close(id: string): void {
    if (this.modal && this.modal.id === id) {
      this.modal.openModal();
    }
    this.modal.closeModal();
  }
  remove(id: string): void {
    if (this.modal && this.modal.id === id) {
      this.modal = undefined;
    }
  }
  get(): any{
    return this.modal;
  }
}
