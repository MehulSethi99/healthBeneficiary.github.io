import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HealthPackageListComponent } from './health-package-list.component';

describe('HealthPackageListComponent', () => {
  let component: HealthPackageListComponent;
  let fixture: ComponentFixture<HealthPackageListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HealthPackageListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HealthPackageListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
