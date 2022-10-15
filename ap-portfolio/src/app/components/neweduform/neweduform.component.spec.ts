import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NeweduformComponent } from './neweduform.component';

describe('NeweduformComponent', () => {
  let component: NeweduformComponent;
  let fixture: ComponentFixture<NeweduformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ NeweduformComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(NeweduformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
