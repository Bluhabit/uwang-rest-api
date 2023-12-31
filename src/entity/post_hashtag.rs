//! `SeaORM` Entity. Generated by sea-orm-codegen 0.12.3

use sea_orm::entity::prelude::*;
use serde::{Deserialize, Serialize};

#[derive(Clone, Debug, PartialEq, DeriveEntityModel, Eq, Serialize, Deserialize)]
#[sea_orm(table_name = "post_hashtag")]
pub struct Model {
    #[sea_orm(primary_key, auto_increment = false)]
    pub id: String,
    pub post_id: Option<String>,
    pub hashtag_id: Option<String>,
    pub updated_at: DateTimeWithTimeZone,
    pub created_at: DateTimeWithTimeZone,
    pub deleted: bool,
}

#[derive(Copy, Clone, Debug, EnumIter, DeriveRelation)]
pub enum Relation {
    #[sea_orm(
        belongs_to = "super::hashtag::Entity",
        from = "Column::HashtagId",
        to = "super::hashtag::Column::Id",
        on_update = "NoAction",
        on_delete = "NoAction"
    )]
    Hashtag,
    #[sea_orm(
        belongs_to = "super::post::Entity",
        from = "Column::PostId",
        to = "super::post::Column::Id",
        on_update = "NoAction",
        on_delete = "NoAction"
    )]
    Post,
}

impl Related<super::hashtag::Entity> for Entity {
    fn to() -> RelationDef {
        Relation::Hashtag.def()
    }
}

impl Related<super::post::Entity> for Entity {
    fn to() -> RelationDef {
        Relation::Post.def()
    }
}

impl ActiveModelBehavior for ActiveModel {}
