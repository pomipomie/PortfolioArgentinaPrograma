import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EduformComponent } from './eduform.component';

describe('EduformComponent', () => {
  let component: EduformComponent;
  let fixture: ComponentFixture<EduformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EduformComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EduformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
