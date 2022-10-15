import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewexpformComponent } from './newexpform.component';

describe('NewexpformComponent', () => {
  let component: NewexpformComponent;
  let fixture: ComponentFixture<NewexpformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewexpformComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewexpformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
