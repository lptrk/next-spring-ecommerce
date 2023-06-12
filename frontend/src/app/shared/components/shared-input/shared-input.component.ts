import { Component, Input } from '@angular/core';

@Component({
  selector: 'shared-input',
  templateUrl: './shared-input.component.html',
})
export class SharedInputComponent {
  inputPlaceholder: string = '';
  inputType: string = '';

  @Input()
  set placeholder(placeholder: string) {
    this.inputPlaceholder = placeholder;
  }

  @Input()
  set type(type: string) {
    this.inputType = type;
  }
}
