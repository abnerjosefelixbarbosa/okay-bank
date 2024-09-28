import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProduteAndServiceComponent } from './produte-and-service.component';

describe('ProduteAndServiceComponent', () => {
  let component: ProduteAndServiceComponent;
  let fixture: ComponentFixture<ProduteAndServiceComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProduteAndServiceComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProduteAndServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
