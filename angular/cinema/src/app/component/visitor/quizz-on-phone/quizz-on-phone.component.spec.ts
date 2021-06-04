import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QuizzOnPhoneComponent } from './quizz-on-phone.component';

describe('QuizzOnPhoneComponent', () => {
  let component: QuizzOnPhoneComponent;
  let fixture: ComponentFixture<QuizzOnPhoneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QuizzOnPhoneComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(QuizzOnPhoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
