import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewproformComponent } from './newproform.component';

describe('NewproformComponent', () => {
  let component: NewproformComponent;
  let fixture: ComponentFixture<NewproformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NewproformComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NewproformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
