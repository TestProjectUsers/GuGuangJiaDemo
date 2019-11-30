let vm = new Vue({
    el:"#main-container",
    data:{

    },methods:{
        show:function (id) {
            axios({
                url:"manager/sysarea/selectAllArea",
                method:"post",
            }).then(response =>{
                // layer.roleMsg = response.data
                let index = layer.open({
                    type:2,
                    title:'更新用户权限',
                    content:'html/role/role-user.html',
                    area:['80%','80%']
                });
            }).catch()
        }
    }
})