import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentsDemoComponent } from './payments-demo.component';

describe('PaymentsDemoComponent', () => {
  let component: PaymentsDemoComponent;
  let fixture: ComponentFixture<PaymentsDemoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaymentsDemoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PaymentsDemoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
