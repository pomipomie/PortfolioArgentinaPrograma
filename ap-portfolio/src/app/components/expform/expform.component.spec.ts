import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExpformComponent } from './expform.component';

describe('ExpformComponent', () => {
  let component: ExpformComponent;
  let fixture: ComponentFixture<ExpformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ExpformComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ExpformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
