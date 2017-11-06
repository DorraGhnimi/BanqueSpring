var app = angular.module("BanqueApp", []);
app.controller("BanqueController", function($scope, $http) {

	$scope.compte = null; // pathParam
	$scope.codeCompte = null;

	$scope.operation = {
		type : "versement",
		montant : 0,
		codeCompte2 : null
	};
	$scope.pageOperations = [];

	$scope.pageCourante = 0;
	$scope.pageSize = 5;

	
	$scope.errorMessage=null;
	$scope.errorMessageCodeCompte=null;

	
	
	
	
	
	$scope.chargerCompte = function() {
		$scope.errorMessageCodeCompte=null;
		$scope.pageCourante = 0;
		$http.get("/comptes/" + $scope.codeCompte).then(
				function successCallback(response) {
					console.log(response.data);
					$scope.compte = response.data;
					$scope.chargerOperations();
				}, function errorCallback(error) {
					console.log(error, 'can not get data.');
					$scope.errorMessageCodeCompte=error.data.message;
					
				});

	};

	$scope.chargerOperations = function() {
		

		$http.get(
				"/operations?codeCompte=" + $scope.codeCompte + "&page="
						+ $scope.pageCourante + "&size=" + $scope.pageSize)
				.then(function successCallback(response) {
					console.log(response.data);
					$scope.pageOperations = response.data;
					$scope.pages = new Array(response.data.totalPages);

				}, function errorCallback(error) {
					console.log(error, 'can not get data.');
				});

	};

	$scope.goToPage = function(page) {
		$scope.pageCourante = page;
		$scope.chargerOperations();
	};

	$scope.saveOperation = function() {
		$scope.errorMessage=null;

		$http(
				{
					method : 'put',
					url : $scope.operation.type,
					data : "codeCompte=" + $scope.codeCompte + "&montant="
							+ $scope.operation.montant + "&codeEmploye=1",
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).then(function(response) {
					$scope.chargerCompte();
					
					
					console.log("mRRResponse==="+response);
				}, function(error) {
					$scope.errorMessage=error.data.message;
					console.log(error.data.message);
					
				}

		);

	};

	$scope.saveOperationVirement = function() {
		
		$scope.errorMessage=null;

		
		console.log($scope.codeCompte);
		console.log($scope.operation.codeCompte2);
		console.log($scope.operation.montant);

		$http(
				{
					method : 'put',
					url : 'virement',
					data : "compte1=" + $scope.codeCompte + "&compte2="
							+ $scope.operation.codeCompte2 + "&montant="
							+ $scope.operation.montant + "&codeEmploye=1",
					headers : {
						'Content-Type' : 'application/x-www-form-urlencoded'
					}
				}).then(function(response) {
			$scope.chargerCompte();

		}, function(error) {
			$scope.errorMessage=error.data.message;
			console.log(error.data.message);
		}

		);
	};

});

/*
 * offerts par angular : $scope : le model $http : l'objet avec lequel je vais
 * envoyer des requetes http
 * 
 */
