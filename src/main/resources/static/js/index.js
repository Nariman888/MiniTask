
function allFunction(){
    companiesSelect();
    specialtiesSelect();
    loadSpecialities();
    loadCompanies();
    loadQuestionnaires();
}

// COMPANY JS
function openAddModal(){
    const myModal = new bootstrap.Modal('#addCompanyModal', {backdrop: true, focus:false, keyboard: false});
    myModal.show();
}

function openDeleteModal(companyId){
    const myModal = new bootstrap.Modal('#deleteCompanyModal', {backdrop: true, focus:false, keyboard: false});

    deleteCompanyId.value = companyId;
    myModal.show();
}

function openDetailsModal(companyId){
    const myModal = new bootstrap.Modal('#CompanyDetailsModal', {backdrop: true, focus:false, keyboard: false});

    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {

        var company = JSON.parse(this.responseText);

        editCompanyId.value = company.id;
        editCompanyName.value = company.name;

        myModal.show();
    }
    xhttp.open("GET", "http://localhost:8000/admin/company/"+companyId);
    xhttp.send();
}

function addCompany() {

    var bodyObj = {
        "name": addCompanyName.value
    }

    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        loadCompanies();
        addCompanyName.value = "";
    }
    xhttp.open("POST", "http://localhost:8000/admin/company");
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj));
}

function saveCompany() {
    var bodyObj = {
        "id": editCompanyId.value,
        "name": editCompanyName.value
    }

    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        loadCompanies();
    }
    xhttp.open("PUT", "http://localhost:8000/admin/company");
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj));
}

function loadCompanies() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        var companies = JSON.parse(this.responseText);
        var tableContent = "";
        for(var i=0;i<companies.length;i++){
            tableContent+="<tr>";
            tableContent+="<td>"+companies[i].id+"</td>";
            tableContent+="<td>"+companies[i].name+"</td>";
            tableContent+="<td><button class = 'btn btn-dark btn-sm' onclick = 'openDetailsModal("+companies[i].id+")'>DETAILS</button></td>";
            tableContent+="<td style = 'text-align:center;'><button class = 'btn btn-danger btn-sm' onclick = 'openDeleteModal("+companies[i].id+")'>X</button></td>";
            tableContent+="</tr>";
        }
        document.getElementById("companyList").innerHTML = tableContent;
    }
    xhttp.open("GET", "http://localhost:8000/admin/company");
    xhttp.send();
}


function deleteCompany() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        loadCompanies();
    }
    xhttp.open("DELETE", "http://localhost:8000/admin/company/"+deleteCompanyId.value);
    xhttp.send();
}
/////////////
// SPECIALTY JS
function SopenAddModal(){
    const myModal = new bootstrap.Modal('#addSpecialtyModal', {backdrop: true, focus:false, keyboard: false});
    myModal.show();
}

function SopenDeleteModal(SpecialtyId){
    const myModal = new bootstrap.Modal('#deleteSpecialtyModal', {backdrop: true, focus:false, keyboard: false});

    deleteSpecialtyId.value = SpecialtyId;
    myModal.show();
}

function SopenDetailsModal(SpecialtyId){
    const myModal = new bootstrap.Modal('#SpecialtyDetailsModal', {backdrop: true, focus:false, keyboard: false});

    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {

        var specialty = JSON.parse(this.responseText);

        editSpecialtyId.value = specialty.id;
        editSpecialtyName.value = specialty.name;

        myModal.show();
    }
    xhttp.open("GET", "http://localhost:8000/admin/specialty/"+SpecialtyId);
    xhttp.send();
}

function addSpecialty() {

    var bodyObj = {
        "name": addSpecialtyName.value
    }

    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        loadSpecialities();
        addSpecialtyName.value = "";
    }
    xhttp.open("POST", "http://localhost:8000/admin/specialty");
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj));
}

function saveSpecialty() {
    var bodyObj = {
        "id": editSpecialtyId.value,
        "name": editSpecialtyName.value
    }

    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        loadSpecialities();
    }
    xhttp.open("PUT", "http://localhost:8000/admin/specialty");
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj));
}

function loadSpecialities() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        var specilities = JSON.parse(this.responseText);
        var tableContent = "";
        for(var i=0;i<specilities.length;i++){
            tableContent+="<tr>";
            tableContent+="<td>"+specilities[i].id+"</td>";
            tableContent+="<td>"+specilities[i].name+"</td>";
            tableContent+="<td><button class = 'btn btn-dark btn-sm' onclick = 'SopenDetailsModal("+specilities[i].id+")'>DETAILS</button></td>";
            tableContent+="<td style = 'text-align:center;'><button class = 'btn btn-danger btn-sm' onclick = 'SopenDeleteModal("+specilities[i].id+")'>X</button></td>";
            tableContent+="</tr>";
        }
        specialtyList.innerHTML = tableContent;
    }
    xhttp.open("GET", "http://localhost:8000/admin/specialty");
    xhttp.send();
}


function deleteSpecialty() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        loadSpecialities();
    }
    xhttp.open("DELETE", "http://localhost:8000/admin/specialty/"+deleteSpecialtyId.value);
    xhttp.send();
}
function companiesSelect(){
    xhttp = new XMLHttpRequest();
    var list = "";
    xhttp.onload = function (){
        var companies = JSON.parse(this.responseText)
        for (let i = 0; i < companies.length; i++) {
            list +="<option value='"+companies[i].id+"'>"
            list +=companies[i].name
            list +="</option>"
        }
        companiesList.innerHTML = list;
    }
    xhttp.open("GET", "http://localhost:8000/admin/company")
    xhttp.send();
}
function specialtiesSelect(){
    xhttp = new XMLHttpRequest();
    var list = "";
    xhttp.onload = function (){
        var specialties = JSON.parse(this.responseText)
        for (let i = 0; i < specialties.length; i++) {
            list +="<option value='"+specialties[i].id+"'>"
            list +=specialties[i].name
            list +="</option>"
        }
        specialtiesList.innerHTML = list;
    }
    xhttp.open("GET", "http://localhost:8000/admin/specialty")
    xhttp.send();
}
function addData() {
    var bodyObj = {
        "userName": addName.value,
        "userSurname": addSurname.value,
        "userDate": addDate.value,
        "skill": addSkill.value,
        "company": {
            "id":companiesList.value
        },
        "specialty": {
            "id":specialtiesList.value
        }
    }

    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        loadCompanies();
        addName.value = "";
        addSurname.value = "";
        addSkill.value = ""
    }
    xhttp.open("POST", "http://localhost:8000/questionnaire");
    xhttp.setRequestHeader("Content-type", "application/json;charset=UTF-8");
    xhttp.send(JSON.stringify(bodyObj));
}

function loadQuestionnaires() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        var questionnaires = JSON.parse(this.responseText);
        var tableContent = "";
        for(var i=0;i<questionnaires.length;i++){
            tableContent+="<tr>";
            tableContent+="<td>"+questionnaires[i].id+"</td>";
            tableContent+="<td>"+questionnaires[i].userSurname + "  " + questionnaires[i].userName +"</td>";
            tableContent+="<td>"+questionnaires[i].userDate+"</td>";
            tableContent+="<td>"+questionnaires[i].skill+"</td>";
            tableContent+="<td>"+questionnaires[i].company.name+"</td>";
            tableContent+="<td>"+questionnaires[i].specialty.name+"</td>";
            tableContent+="</tr>";
        }
        questionnaireList.innerHTML = tableContent;
    }
    xhttp.open("GET", "http://localhost:8000/questionnaire");
    xhttp.send();
}