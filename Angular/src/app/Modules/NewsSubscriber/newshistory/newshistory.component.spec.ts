import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NewshistoryComponent } from './newshistory.component';

describe('NewshistoryComponent', () => {
  let component: NewshistoryComponent;
  let fixture: ComponentFixture<NewshistoryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NewshistoryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NewshistoryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
