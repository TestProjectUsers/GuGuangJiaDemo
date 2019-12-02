let vm = new Vue({
    el:"#main-container",
    data:function(){
        return {
            pageInfo: {
                pageNum: 1,
                pageSize: 5
            },
            setting: {
                data: {
                    key: {
                        title: "fullName"
                    },
                    simpleData: {
                        enable: true,
                        pIdKey: "parentId"
                    }
                },
                callback: {
                    onClick: this.onClick
                },
                view: {
                }

            },
            params: {
                pageNum: '',
                pageSize: '',
                officeName:'',
                aid:0
            },
            name: '',
            nodes: [],
            treeObj: {},
            node: ''
        }
    },
    methods:{
        initTree: function () {
            axios({
                url: "manager/sysoffice/list"

            }).then(response => {
                this.nodes = response.data
                this.nodes [this.nodes.length]={
                    "id":0,
                    "name":"所有机构"
                }
                let treeobj = $.fn.zTree.init($("#treeMenu"), this.setting, this.nodes)
                treeobj.expandAll(true)
                console.log(treeobj)
                this.treeObj = treeobj
                console.log(this.treeObj)

            }).catch(function (error) {
                console.log(error)
            })
        },onClick: function (event, treeId, treeNode) {
            console.log(treeNode)
            this.params.aid = treeNode.id
        },
        selectAll:function (pageNum,pageSize) {
            this.params.pageNum = pageNum
            this.params.pageSize = pageSize
            axios({
                url: "manager/sysoffice/selectByCondition",
                data:this.params,
                method:"post"
            }).then( response =>{
                this.pageInfo = response.data

            }).catch(function (error) {
                console.log(error)
            })
        },
        selectByNoCondition:function () {
            this.params ={officeName: '',aid:''}
            this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize);
        },toUpdate:function (id) {
            axios({
                url:"manager/sysoffice/toUpdate",
                data:{id:id}
            }).then( response =>{
                layer.obj = response.data
                console.log(response.data)
                let index = layer.open({
                    type:2,
                    title: '修改信息',
                    content: 'html/office/update.html',
                    area:['80%','80%'],
                    end: () =>{
                        this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize)
                    }
                });
            }).catch(function (error) {
                console.log(error)
            })
        }

    },
    created: function () {
        this.selectAll(this.pageInfo.pageNum, this.pageInfo.pageSize);
    }, mounted: function () {
        this.initTree();
    }
})