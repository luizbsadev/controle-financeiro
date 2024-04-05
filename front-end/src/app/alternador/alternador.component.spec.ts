import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlternadorComponent } from './alternador.component';

describe('AlternadorComponent', () => {
  let component: AlternadorComponent;
  let fixture: ComponentFixture<AlternadorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlternadorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AlternadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
