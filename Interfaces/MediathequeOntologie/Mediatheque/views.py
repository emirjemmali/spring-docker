
import  requests
from django.shortcuts import render
def listRmployees(request):
    list = []
    response = requests.get("http://localhost:8081/employees")
    items = response.json()
    for j in items:
        print(j);
        list.append(j);
    return render(request, 'listEmployees.html',
                  {'employees': list})
def searchByEmail(request):
    list=[]
    tag=request.GET['searchEmail'];
    print(tag);
    response = requests.get("http://localhost:8081/employees/byEmail?email="+tag)
    items = response.json()
    for j in items:
        print(j);
        list.append(j);
    return render(request, 'listEmployees.html', {
                'employees': list,})