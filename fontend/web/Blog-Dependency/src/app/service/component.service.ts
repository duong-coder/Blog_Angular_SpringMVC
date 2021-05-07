import { Injectable, ComponentFactoryResolver, Component, ViewContainerRef } from '@angular/core';
import { InputComponent } from '../model/input-component';

@Injectable({
  providedIn: 'root'
})
export class ComponentService {
  rootViewContainer: ViewContainerRef;

  constructor(private factoryResolver: ComponentFactoryResolver) { }

  setRootViewContainerRef(viewContainerRef: ViewContainerRef): void {
    this.rootViewContainer = viewContainerRef;
  }
  addComponent(componentAppend, args: InputComponent[]): void {
    const factory = this.factoryResolver
      .resolveComponentFactory(componentAppend);

    const component = factory
      .create(this.rootViewContainer.parentInjector);

    args.forEach(arg => {
      component.instance[arg.prop] = arg.value;
    });

    this.rootViewContainer.insert(component.hostView);
  }
}
