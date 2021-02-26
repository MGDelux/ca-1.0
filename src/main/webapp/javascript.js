   
        let boys = new Array("Peter", "lars", "Ole");
        let girls = new Array("Janne", "hanne", "Sanne");
        let all = boys.concat(girls);
        
        
    function AddBoy() {
            let y = document.getElementById("text_boy").value;
            boys.push(y);
            for(i = 0; i < boys.length; i++ ){
            console.log(boys[i]);
            let HTML = "<li>" + boys[i] + "</li>";             
            document.getElementById("Boys_row").innerHTML += "<ul>" + HTML + "</ul>";
        };
            
        };
       

        function AddGirl() {
         let y = document.getElementById("text_girl").value;
            girls.push(y);
            for(i = 0; i < girls.length; i++ ){
            console.log(girls[i]);
            let HTML = "<li>" + girls[i] + "</li>";             
            document.getElementById("Girls_row").innerHTML += "<ul>" + HTML + "</ul>";
        };
    }
    
        function clearBoxBoys() { 
            var div = document.getElementById("Boys_row"); 
              
            while(div.firstChild) { 
                div.removeChild(div.firstChild); 
            } 
        } 
        function clearBoxGirls() { 
            var div = document.getElementById("Girls_row"); 
              
            while(div.firstChild) { 
                div.removeChild(div.firstChild); 
            } 
        } 
        function clearBoxAll() { 
            var div = document.getElementById("All_row"); 
              
            while(div.firstChild) { 
                div.removeChild(div.firstChild); 
            } 
        } 
        function clearTable() { 
            var rowCount = table.rows.length;
        for (var i = rowCount - 1; i > 0; i--) {
            table.deleteRow(i);
        }
    }

    function RemoveBoy() {
    if(document.getElementById("Remove_first").checked){
     boys.shift();
    }if(document.getElementById("Remove_last").checked){
      boys.pop();
    }
    clearBoxBoys("Boys_row");
     for(i = 0; i < boys.length; i++ ){
            console.log(boys[i]);
            let HTML = "<li>" + boys[i] + "</li>";             
            document.getElementById("Boys_row").innerHTML += "<ul>" + HTML + "</ul>";
        };
    }
    
      function RemoveGirl() {
    if(document.getElementById("Remove_first").checked){
     girls.shift();
    }if(document.getElementById("Remove_last").checked){
      girls.pop();
    }
    clearBoxGirls("Girls_row");
     for(i = 0; i < girls.length; i++ ){
            console.log(girls[i]);
            let HTML = "<li>" + girls[i] + "</li>";             
            document.getElementById("Girls_row").innerHTML += "<ul>" + HTML + "</ul>";
        };
    }
    
    function ReverseAll(){
    boys.splice(0,boys.length);
    girls.splice(0,girls.length);
    
    }
    
    function SortAll(){
        let all = boys.concat(girls).sort((a,b) => a.toLowerCase().localeCompare(b.toLowerCase()));
       
    clearBoxAll("All_row");
     for(i = 0; i < all.length; i++ ){
            console.log(all[i]);
            let HTML = "<li>" + all[i] + "</li>";             
            document.getElementById("All_row").innerHTML += "<ul>" + HTML + "</ul>";
        };
    }
    
    function onLoad(){
        for(i = 0; i < boys.length; i++ ){
            let HTML = "<li>" + boys[i] + "</li>";             
            document.getElementById("Boys_row").innerHTML += "<ul>" + HTML + "</ul>";
        };
         for(i = 0; i < girls.length; i++ ){
            let HTML = "<li>" + girls[i] + "</li>";             
            document.getElementById("Girls_row").innerHTML += "<ul>" + HTML + "</ul>";
        };
        for(i = 0; i < all.length; i++ ){
            let HTML = "<li>" + all[i] + "</li>";             
            document.getElementById("All_row").innerHTML += "<ul>" + HTML + "</ul>";
        };
    }
    
    function getAllCars(){
        fetch("/ca-1/api/cars/all").then( res => res.json()).then(data =>{
        console.log("Cars: ",data);
        let cars = data;
        let table = document.getElementById('table');
        clearTable();
        for(i = 0; i < cars.length; i++ ){
                var row = `<tr> 
                        <td>${cars[i].id}</td> 
                        <td>${cars[i].make}</td> 
                        <td>${cars[i].model}</td>
                        <td>${cars[i].year}</td>
                        <td>${cars[i].price}</td>
                        <td>${cars[i].owner}</td>
                         </tr>`;
            table.innerHTML += row;
        };
    });
    }
    
    function filter_year(){
    fetch("/ca-1/api/cars/all").then( res => res.json()).then(data =>{
    let cars = data;
    let value = document.getElementById("number_year").value;
    let newCar = cars.filter((element) => element.year <= value);
    clearTable();
    for(i = 0; i < newCar.length; i++ ){
        console.log(newCar);
                var row = `<tr> 
                        <td>${newCar[i].id}</td> 
                        <td>${newCar[i].make}</td> 
                        <td>${newCar[i].model}</td>
                        <td>${newCar[i].year}</td>
                        <td>${newCar[i].price}</td>
                        <td>${newCar[i].owner}</td>
                         </tr>`;
            table.innerHTML += row;
        };
    });
    }

     function filter_price(){
    fetch("/ca-1/api/cars/all").then( res => res.json()).then(data =>{
    let cars = data;
    let value = document.getElementById("number_price").value;
    let newCar = cars.filter((element) => element.price <= value);
    clearTable();
    for(i = 0; i < newCar.length; i++ ){
        console.log(newCar);
                var row = `<tr> 
                        <td>${newCar[i].id}</td> 
                        <td>${newCar[i].make}</td> 
                        <td>${newCar[i].model}</td>
                        <td>${newCar[i].year}</td>
                        <td>${newCar[i].price}</td>
                        <td>${newCar[i].owner}</td>
                         </tr>`;
            table.innerHTML += row;
        };
    });
    }
    
function filter_volvo(){
    fetch("/ca-1/api/cars/all").then( res => res.json()).then(data =>{
    let cars = data;
    let newCar = cars.filter((element) => element.make === "Volvo");
    clearTable();
    for(i = 0; i < newCar.length; i++ ){
        console.log(newCar);
                var row = `<tr> 
                        <td>${newCar[i].id}</td> 
                        <td>${newCar[i].make}</td> 
                        <td>${newCar[i].model}</td>
                        <td>${newCar[i].year}</td>
                        <td>${newCar[i].price}</td>
                        <td>${newCar[i].owner}</td>
                         </tr>`;
            table.innerHTML += row;
        };
    });
    }
    
    function filter_hyundai(){
    fetch("/ca-1/api/cars/all").then( res => res.json()).then(data =>{
    let cars = data;
    let newCar = cars.filter((element) => element.make === "Hyundai");
    clearTable();
    for(i = 0; i < newCar.length; i++ ){
        console.log(newCar);
                var row = `<tr> 
                        <td>${newCar[i].id}</td> 
                        <td>${newCar[i].make}</td> 
                        <td>${newCar[i].model}</td>
                        <td>${newCar[i].year}</td>
                        <td>${newCar[i].price}</td>
                        <td>${newCar[i].owner}</td>
                         </tr>`;
            table.innerHTML += row;
        };
    });
    }  
    
    function filter_bmw(){
    fetch("/ca-1/api/cars/all").then( res => res.json()).then(data =>{
    let cars = data;
    let newCar = cars.filter((element) => element.make.toLowerCase().match("bmw"));
    clearTable();
    for(i = 0; i < newCar.length; i++ ){
        console.log(newCar);
                var row = `<tr> 
                        <td>${newCar[i].id}</td> 
                        <td>${newCar[i].make}</td> 
                        <td>${newCar[i].model}</td>
                        <td>${newCar[i].year}</td>
                        <td>${newCar[i].price}</td>
                        <td>${newCar[i].owner}</td>
                         </tr>`;
            table.innerHTML += row;
        };
    });
    } 