import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateHealthPackageComponent } from './update-health-package.component';

describe('UpdateHealthPackageComponent', () => {
  let component: UpdateHealthPackageComponent;
  let fixture: ComponentFixture<UpdateHealthPackageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpdateHealthPackageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateHealthPackageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
