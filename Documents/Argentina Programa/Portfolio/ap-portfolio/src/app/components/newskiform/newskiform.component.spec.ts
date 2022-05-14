import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewskiformComponent } from './newskiform.component';

describe('NewskiformComponent', () => {
  let component: NewskiformComponent;
  let fixture: ComponentFixture<NewskiformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewskiformComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewskiformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
