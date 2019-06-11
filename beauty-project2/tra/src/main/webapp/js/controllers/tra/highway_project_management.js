'use highway_project_management';


app.controller('Highway_project_managementCtrl', ['$scope', function($scope) {
      $scope.data={
        formList:['项目信息表','项目列表','项目周期','标段周期','标段列表','人员登记','单位管理','质量台账','施工图审批','交工信息','竣工信息','台账修正（工程部分）','台账修正(台账信息)','台账修正','工程台账（工程部分）','工程台账（台帐信息）','变更方案','变更申请'],
          url:['project','project','project','block','block','block','unit','unit','unit','completion','completion','completion','parameter','parameter','parameter','engineering','engineering','engineering'],
          fold:['','starred','sent','important','draft','express','a','b','c','d','e','f','g','h','i','j','k','l']
      }


  }]);





































