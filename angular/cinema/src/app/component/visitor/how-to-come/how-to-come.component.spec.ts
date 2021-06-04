import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HowToComeComponent } from './how-to-come.component';

describe('HowToComeComponent', () => {
  let component: HowToComeComponent;
  let fixture: ComponentFixture<HowToComeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HowToComeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HowToComeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
