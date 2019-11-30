let vm = new Vue({
    el:"#main-container",
    data:{
        pageInfo:{
            pageNum:1,
            pageSize:5
        },
        params:{
            pageNum:'',
            pageSize:'',
            type:'',
            check:'',
            BeginTime:'',
            EndTime:''
        }
    },methods:{
        selectAll:function(pageNum,pageSize){
            this.params.pageNum = pageNum
            this.params.pageSize = pageSize
            axios({
                url:"manager/qualification/select",
                method: "post",
                data:this.params
            }).then(response =>{
                this.pageInfo = response.data
                console.log(response.data)
            }).catch(function (error) {
                layer.msg(error)
            })
        },
        toUpdate:function (id) {
            axios({
                url: "manager/qualification/toUpdate",
                params:{id:id}
            }).then(response =>{
                layer.obj = response.data;
                console.log(response.data)
                let index = layer.open({
                    type: 2,
                    title: '资质审核',
                    content: 'html/qualification/update.html',
                    area: ['80%', '80%'],
                    end: () => {
                        this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize)
                    }
                });
            }).catch(function (error) {
                console.log(error)
            })
        },
        selectAllNoCondition:function (pageNum, pageSize) {
            this.params={type: '',check: ''}
            this.selectAll(pageNum,pageSize)
        }
    },
    created:function () {
        this.selectAll(this.pageInfo.pageNum,this.pageInfo.pageSize)
    }
})