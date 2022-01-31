import { Component, OnInit, Output, EventEmitter } from '@angular/core';


@Component({
  selector: 'app-payments-demo',
  templateUrl: './payments-demo.component.html',
  styleUrls: ['./payments-demo.component.scss']
})
export class PaymentsDemoComponent implements OnInit {

  constructor() { }
  @Output() paymentStatus = new EventEmitter();

  ngOnInit(): void {
  }


  onLoadPaymentData($event){
    this.paymentStatus.emit(true)
    console.log("Payment done event -> ", event)
  }

}
