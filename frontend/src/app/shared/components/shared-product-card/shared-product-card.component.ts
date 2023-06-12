import { Component, Input } from '@angular/core';

@Component({
  selector: 'shared-product-card',
  templateUrl: './shared-product-card.component.html',
})
export class SharedProductCardComponent {
  cardImageUrl: string = '';
  cardPrice: string = '';
  cardCaption: string = '';

  @Input()
  set src(url: string) {
    this.cardImageUrl = url;
  }
  @Input()
  set price(price: string) {
    this.cardPrice = price;
  }
  @Input()
  set caption(caption: string) {
    this.cardCaption = caption;
  }
}
