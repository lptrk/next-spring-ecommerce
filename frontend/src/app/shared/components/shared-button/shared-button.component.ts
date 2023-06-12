import { Component, Input } from '@angular/core';

@Component({
  selector: 'shared-button',
  templateUrl: './shared-button.component.html',
})
export class SharedButtonComponent {
  public buttonText = '';

  @Input()
  set text(name: string) {
    this.buttonText = name;
  }
}
