'use hunan_transport';


app.controller('Hunan_transportCtrl', ['$scope', function($scope) {
      $scope.data={
        formList:['交通责任事故表','车辆信用考核表','车辆责令整改表','社会投诉表','业户考核申报表','从业人员考核签注表','违规上访表','设备档案表','电子签章申报内容表','设施档案表','政府运输任务表','经营违章表','企业荣誉表','业户责令整改表','整改内容表','规章制度表','恶性服务事件表','继续教育记录','员工信息表','先进事迹表','申诉主表'],
          url:['vehicle','vehicle','vehicle','complaint','complaint','complaint','petition','petition','petition','facilities','facilities','facilities','honor','honor','honor','rules','rules','rules','vehicle','vehicle','vehicle'],
          fold:['','starred','sent','important','draft','trash','a','b','c','d','e','f','g','h','i','j','k','l','m','n','o']
      }


  }]);