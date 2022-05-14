import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SkiformComponent } from './skiform.component';

describe('SkiformComponent', () => {
  let component: SkiformComponent;
  let fixture: ComponentFixture<SkiformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SkiformComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SkiformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
