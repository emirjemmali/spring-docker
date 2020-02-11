from django.urls import re_path, path

from Mediatheque import views

urlpatterns = [


    path('employees/', views.listRmployees, name='employees'),
    re_path(r'^searchEmail/$', views.searchByEmail, name='searchEmail'),


]