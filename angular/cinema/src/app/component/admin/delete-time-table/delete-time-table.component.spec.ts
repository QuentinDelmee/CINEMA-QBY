import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DeleteTimeTableComponent } from './delete-time-table.component';

describe('DeleteTimeTableComponent', () => {
  let component: DeleteTimeTableComponent;
  let fixture: ComponentFixture<DeleteTimeTableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DeleteTimeTableComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DeleteTimeTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
