var UserProfile = (function() {
    var id = 'tsisy';

    var getId = function() {
      return id;    // Or pull this from cookie/localStorage
    };
  
    var setId = function(name) {
      id = name;     
      // Also set this in cookie/localStorage
    };
  
    return {
      getId: getId,
      setId: setId
    }
  
  });
  
  export default UserProfile;