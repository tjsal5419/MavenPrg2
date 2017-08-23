var memberListModule = angular.module("member-list", []);

memberListModule.controller("member-list-controller", function ($scope,$http) {
    // var memberList = [
    //     { "id": "newlec", "name": "뉴렉", "checked":false },
    //     { "id": "newlec", "name": "손오공", "checked":false },
    //     { "id": "newlec", "name": "뉴렉", "checked":false },
    //     { "id": "newlec", "name": "손오공", "checked":false },
    //     { "id": "newlec", "name": "뉴렉", "checked":false },
    //     { "id": "newlec", "name": "손오공", "checked":false }
    // ];
   
   var memberList= [];
   
   $http({
      method : "GET",
      url : "/MavenPrj/admin/get-member-list"
   }).then(function(response) {
      $scope.list = response.data;
   });
    

    $scope.list = memberList;

    $scope.allCheck = false;
    $scope.allButtonClick=function(){
        for(var i in memberList){
            $scope.list[i].checked = $scope.allCheck;
        }
    };
    
    // $scope.allButtonClick=function(){

    //     for(var i in memberList){
    //         if(memberList[i].checked==false){
    //             memberList[i].checked=true; 
    //         }
    //         else if(memberList[i].checked==false||memberList[i].checked==true){
    //              memberList[i].checked=true; 
    //          }
           
    //         else if(memberList[i].every(checked)){
    //             memberList[i].checked=false; 

    //         }
           
    //     }     
    // };

    $scope.delButtonClick= function(){
       
       var size = $scope.list.length;
       for(var i =0; i<size; i++){
          if($scope.list[size-1-i].checked)
             $scope.list.splice(size-1-i,1);
       }
       
        /*for(var i in memberList){
            if(memberList[i].checked){
                memberList[i].splice(i, i);
            }
        }*/
    }

    $scope.searchButtonClick=function(){
       $http({
           method:"GET",
           url:"/MavenPrj/admin/get-member-list?id="+ $scope.queryText
       }).then(function(response){
          $scope.list=response.data;
       });
   };
   
   
   
});